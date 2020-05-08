package com.prokarma.retail.customer.service.consumer.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response
 */
@Validated
@javax.annotation.Generated(
    value = "com.prokarma.retail.customer.service.producer.codegen.v3.generators.java.SpringCodegen",
    date = "2020-04-18T05:15:19.983Z[GMT]")
public class Response {
  /**
   * valid response status
   */
  public enum StatusEnum {
    SUCCESS("success"),

    ERROR("error");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("error_type")
  private String errorType = null;

  public Response status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * valid response status
   * 
   * @return status
   **/
  @ApiModelProperty(required = true, value = "valid response status")
  @NotNull

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * 
   * @return message
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Response errorType(String errorType) {
    this.errorType = errorType;
    return this;
  }

  /**
   * type of exception
   * 
   * @return errorType
   **/
  @ApiModelProperty(value = "type of exception")

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.status, response.status)
        && Objects.equals(this.message, response.message)
        && Objects.equals(this.errorType, response.errorType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, errorType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");

    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
