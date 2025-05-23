function HTMLifyDescriptions {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [ValidateScript({ Test-Path $_ -PathType Leaf })]
        [String] $File 
    )
    Write-Progress -Activity "Reading in $File" -Id 2
    $HC = ConvertFrom-Yaml (Get-Content -Raw $File)
    Write-Progress -Activity "Read in $File" -Id 2 -Completed
    $newContents = RecursivelyHTMLifyDescriptions -Content $(Get-Content $File -Raw) -myHashtable $HC
    Out-File -FilePath $File -InputObject $newContents
}

function RecursivelyHTMLifyDescriptions {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [String] $Content,
        [Parameter(Mandatory = $true)]
        [hashtable] $myHashtable,
        [Parameter(Mandatory = $false)]
        [int] $ID = 0
    )
    $myHashtable.Keys | ForEach-Object {
        if ($myHashtable[$_] -is [string] -and -not [string]::IsNullOrEmpty($myHashtable[$_])) {
            Write-Progress -Activity "HTMLifying $myHashtable[$_]" -Id $ID
        }
        if ($myHashtable[$_] -is [hashtable]) {
            RecursivelyHTMLifyDescriptions -Content $Content -myHashtable $myHashtable[$_] ($ID + 1)
        }
        else {
            if ($_ -eq "description" -and $myHashtable[$_] -is [string] -and -not [string]::IsNullOrEmpty($myHashtable[$_])) {
                $Content = HtmlifySnippetsInContent -Content $Content -Snippet $myHashtable[$_] -ID $ID
            }
            else {
                Write-Debug "Skipping '$_' because it is not a description"
            }
        }
    }
    return $Content
}

function HtmlifySnippetsInContent {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [String] $Content,
        [Parameter(Mandatory = $true)]
        [String] $Snippet,
        [Parameter(Mandatory = $false)]
        [int] $ID = 0
    )
    if ($Snippet -match '<.+?>') {
        Write-debug "Snippet appears to be HTML already, skipping Markdown conversion: `"$Snippet`""
        # If it's already HTML, we assume no replacement is needed based on this snippet.
        # Returning $Content without modification is the safest approach here.
        return $Content
    }    
    Write-Progress -Status "HTMLifying $Snippet" -Activity "HTMLifying Descriptions" -Id $ID   
    $HtmlSnippet = ($Snippet | ConvertFrom-Markdown).Html
    return $Content.Replace($Snippet, $HtmlSnippet)
    }