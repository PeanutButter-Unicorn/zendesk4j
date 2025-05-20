package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * VotesResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(VotesResponse.JSON_PROPERTY_VOTES)
public class VotesResponse {

    public static final String JSON_PROPERTY_VOTES = "votes";

    @Nullable
    @JsonProperty(JSON_PROPERTY_VOTES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid VoteObject> votes;

    /**
     * @return the votes property value
     */
    public List<@Valid VoteObject> getVotes() {
        return votes;
    }

    /**
     * Set the votes property value
     *
     * @param votes property value to set
     */
    public void setVotes(List<@Valid VoteObject> votes) {
        this.votes = votes;
    }

    /**
     * Set votes in a chainable fashion.
     *
     * @return The same instance of VotesResponse for chaining.
     */
    public VotesResponse votes(List<@Valid VoteObject> votes) {
        this.votes = votes;
        return this;
    }
    /**
     * Add an item to the votes property in a chainable fashion.
     *
     * @return The same instance of VotesResponse for chaining.
     */
    public VotesResponse addVotesItem(VoteObject votesItem) {
        if (votes == null) {
            votes = new ArrayList<>();
        }
        votes.add(votesItem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var votesResponse = (VotesResponse) o;
        return Objects.equals(votes, votesResponse.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votes);
    }

    @Override
    public String toString() {
        return "VotesResponse("
            + "votes: " + getVotes()
            + ")";
    }

}