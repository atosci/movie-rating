package io.atos.ratingsdataservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author Mohamed El Kawakibi
 * @author Puck School
 */
public class Rating {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;

    // default constructor
    public Rating() {
    }


    /**
     * @param source A String representing the source of the rating
     * @param value A String representing the value of the rating
     */
    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    /** Gets the source of the rating
     * @return A String representing the rating source
     */
    public String getSource() {
        return source;
    }

    /** Sets the source of the rating
     * @param source String representing the rating source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /** Gets the value of the rating
     * @return A String representing the rating value
     */
    public String getValue() {
        return value;
    }

    /** Sets the value of the rating
     * @param value String representing the rating value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
