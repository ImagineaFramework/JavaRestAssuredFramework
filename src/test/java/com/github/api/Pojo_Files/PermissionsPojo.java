package com.github.api.Pojo_Files;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "admin",
            "push",
            "pull"
    })
    public class PermissionsPojo{

        @JsonProperty("admin")
        private Boolean admin;
        @JsonProperty("push")
        private Boolean push;
        @JsonProperty("pull")
        private Boolean pull;

        /**
         * No args constructor for use in serialization
         *
         */
        public PermissionsPojo() {
        }


        @JsonProperty("admin")
        public Boolean getAdmin() {
            return admin;
        }

        @JsonProperty("admin")
        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        @JsonProperty("push")
        public Boolean getPush() {
            return push;
        }

        @JsonProperty("push")
        public void setPush(Boolean push) {
            this.push = push;
        }

        @JsonProperty("pull")
        public Boolean getPull() {
            return pull;
        }

        @JsonProperty("pull")
        public void setPull(Boolean pull) {
            this.pull = pull;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("admin", admin).append("push", push).append("pull", pull).toString();
        }

    }

