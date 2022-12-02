package br.com.agenciaviagens.agenciaviagens.error;

public class ErrosDetails {

    private String title;
    private int status;
    private String details;
    private long timestamp;
    private String developerMessage;

    //construtot
    public ErrosDetails() {
    }

    //getter e setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    //builder
    public static final class ErrosDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String developerMessage;

        private ErrosDetailsBuilder() {
        }

        public static ErrosDetailsBuilder newBuilder() {
            return new ErrosDetailsBuilder();
        }

        public ErrosDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ErrosDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ErrosDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ErrosDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrosDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrosDetails build() {
            ErrosDetails errosDetails = new ErrosDetails();
            errosDetails.setTitle(title);
            errosDetails.setStatus(status);
            errosDetails.setDetails(details);
            errosDetails.setTimestamp(timestamp);
            errosDetails.setDeveloperMessage(developerMessage);
            return errosDetails;
        }
    }

}
