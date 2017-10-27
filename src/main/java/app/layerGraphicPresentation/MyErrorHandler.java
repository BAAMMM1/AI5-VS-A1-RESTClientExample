package app.layerGraphicPresentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author Christian G. on 27.10.2017
 */
public class MyErrorHandler implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("handelError");
        System.out.println(response.getStatusCode());

    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode() != HttpStatus.OK){
            System.out.println("hasError");
            System.out.println(response.getStatusCode());
            return true;
        }

        return false;
    }

    /*
    private static final Log logger = LogFactory.getLog(MyResponseErrorHandler.class);

    @Override
    public void handleError(ClientHttpResponse clienthttpresponse) throws IOException {

        if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
            logger.debug(HttpStatus.FORBIDDEN + " response. Throwing authentication exception");
            throw new AuthenticationException();
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {

        if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
            logger.debug("Status code: " + clienthttpresponse.getStatusCode());
            logger.debug("Response" + clienthttpresponse.getStatusText());
            logger.debug(clienthttpresponse.getBody());

            if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
                logger.debug("Call returned a error 403 forbidden resposne ");
                return true;
            }
        }
        return false;
    }
    */

}