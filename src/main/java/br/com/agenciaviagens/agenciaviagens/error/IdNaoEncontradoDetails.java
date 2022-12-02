package br.com.agenciaviagens.agenciaviagens.error;

public class IdNaoEncontradoDetails extends ErrosDetails{


    public static final class IdNaoEncontradoDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String developerMessage;

        private IdNaoEncontradoDetailsBuilder() {
        }

        public static IdNaoEncontradoDetailsBuilder newBuilder() {
            return new IdNaoEncontradoDetailsBuilder();
        }

        public IdNaoEncontradoDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public IdNaoEncontradoDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public IdNaoEncontradoDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public IdNaoEncontradoDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public IdNaoEncontradoDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public IdNaoEncontradoDetails build() {
            IdNaoEncontradoDetails idNaoEncontradoDetails = new IdNaoEncontradoDetails();
            idNaoEncontradoDetails.setStatus(status);
            idNaoEncontradoDetails.setTimestamp(timestamp);
            idNaoEncontradoDetails.setDeveloperMessage(developerMessage);
            idNaoEncontradoDetails.setTitle(title);
            idNaoEncontradoDetails.setDetails(details);
            return idNaoEncontradoDetails;
        }
    }
}
