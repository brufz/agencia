package br.com.agenciaviagens.agenciaviagens.error;

public class ValidacoesErroDetails extends ErrosDetails{
    private String campo;
    private String mensagemCampo;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagemCampo() {
        return mensagemCampo;
    }

    public void setMensagemCampo(String mensagemCampo) {
        this.mensagemCampo = mensagemCampo;
    }

    public ValidacoesErroDetails() {
    }

    //builder
    public static final class ValidacoesErroDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String developerMessage;
        private String campo;
        private String mensagemCampo;

        private ValidacoesErroDetailsBuilder() {
        }

        public static ValidacoesErroDetailsBuilder newBuilder() {
            return new ValidacoesErroDetailsBuilder();
        }

        public ValidacoesErroDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ValidacoesErroDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ValidacoesErroDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ValidacoesErroDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ValidacoesErroDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ValidacoesErroDetailsBuilder campo(String campo) {
            this.campo = campo;
            return this;
        }

        public ValidacoesErroDetailsBuilder mensagemCampo(String mensagemCampo) {
            this.mensagemCampo = mensagemCampo;
            return this;
        }

        public ValidacoesErroDetails build() {
            ValidacoesErroDetails validacoesErroDetails = new ValidacoesErroDetails();
            validacoesErroDetails.setTitle(title);
            validacoesErroDetails.setStatus(status);
            validacoesErroDetails.setDetails(details);
            validacoesErroDetails.setTimestamp(timestamp);
            validacoesErroDetails.setDeveloperMessage(developerMessage);
            validacoesErroDetails.campo = campo;
            validacoesErroDetails.mensagemCampo = mensagemCampo;
            return validacoesErroDetails;
        }
    }
}
