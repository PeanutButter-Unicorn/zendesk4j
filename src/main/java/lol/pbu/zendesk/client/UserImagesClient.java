package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import lol.pbu.zendesk.model.CreateUserImageResponse;
import lol.pbu.zendesk.model.RequestUserImageUploadResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface UserImagesClient {

    /**
     * Create Image Path<br>
     * Returns the image path that you can use to display the image in a community post.
     * You should only use this endpoint after uploading the image. See
     * <a href="#uploading-the-image-with-the-upload-url">Uploading the image with the upload URL</a>.
     * <h4>Request Body Format</h4>
     * The request body must be a JSON object with the following properties:
     * <table>
     *   <thead>
     *     <tr>
     *       <th>Name</th>
     *       <th>Type</th>
     *       <th>Mandatory</th>
     *       <th>Description</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr>
     *       <td>token</td>
     *       <td>string</td>
     *       <td>true</td>
     *       <td>The image token. See <a href="#create-image-upload-url-and-token">Create Image Upload URL and Token</a></td>
     *     </tr>
     *     <tr>
     *       <td>brand_id</td>
     *       <td>string</td>
     *       <td>true</td>
     *       <td>The ID of the brand where this image was uploaded</td>
     *     </tr>
     *   </tbody>
     * </table>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users</li>
     * </ul>
     *
     *@return Created Response (status code 201)</li>
     */
    @Post("/api/v2/guide/user_images")
    Mono<HttpResponse<@Valid CreateUserImageResponse>> createUserImage();

    /**
     * Create Image Upload URL and Token<br>
     * Returns an upload URL and token. Use the upload URL in a PUT request to upload the image to the help center.
     * See <a href="#uploading-the-image-with-the-upload-url">Uploading the image with the upload URL</a> below.
     * After uploading the image, use the image token to create the image path. See
     * <a href="#create-image-path">Create Image Path</a>.
     *
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users</li>
     * </ul>
     * @return OK Response (status code 200)</li></li>
     */
    @Post("/api/v2/guide/user_images/uploads")
    Mono<@Valid RequestUserImageUploadResponse> requestUserImageUpload();
}
