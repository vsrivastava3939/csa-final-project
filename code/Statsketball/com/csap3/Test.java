package com.csap3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The type Test.
 */
public class Test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(getImage("james harden"));
    }

    /**
     * Gets image.
     *
     * @param name the name
     * @return the image
     */
    public static String getImage(String name) {
        name = replaceSpaces(name);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://en.wikipedia.org/w/api.php?action=opensearch&search=" + name + "&limit=1&namespace=0&format=json"))
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            String resp = response.body();
            String wikiTitle = resp.substring(resp.indexOf(",[\"") + 3, resp.indexOf("\"]"));
            wikiTitle = replaceSpaces(wikiTitle);

            HttpRequest imageReq = HttpRequest.newBuilder()
                    .uri(URI.create("https://en.wikipedia.org/w/api.php?action=query&prop=pageimages&piprop=original&titles=" + wikiTitle + "&format=json"))
                    .method("GET", HttpRequest.BodyPublishers.noBody()).build();
            HttpResponse<String> imageResp = HttpClient.newHttpClient().send(imageReq,
                    HttpResponse.BodyHandlers.ofString());
            return getJPGString(imageResp.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Replace spaces string.
     *
     * @param title the title
     * @return the string
     */
    public static String replaceSpaces(String title) {
        if (title.indexOf(" ") < 0) {
            return title;
        } else {
            return title.substring(0, title.indexOf(" ")) + "+" + replaceSpaces(title.substring(title.indexOf(" ") + 1));
        }
    }

    /**
     * Gets jpg string.
     *
     * @param resp the resp
     * @return the jpg string
     */
    public static String getJPGString(String resp) {
        if (resp != null)
            if (resp.indexOf(".jpg") >= 0)
                return resp.substring(resp.lastIndexOf("http"), resp.lastIndexOf(".jpg") + 4);
            else
                return "";
        else
            return "";
    }
}
