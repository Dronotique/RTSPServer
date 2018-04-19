package cz.warewolf.components.rtsp.server.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: MediaStream</p>
 * <p>
 * Description: </p>
 * <p>Copyright (c) 2018</p>
 * Created on 12.04.2018.
 *
 * @author WarewolfCZ $Revision: $ $Id: $
 */
public class MediaStream {
    private static final Logger log = LoggerFactory.getLogger(MediaStream.class);
    private String mPath;
    private List<MediaStreamPart> mParts;
    private int rtspPort;

    public MediaStream() {
        mParts = new ArrayList<>();
    }

    public MediaStream(String path) throws URISyntaxException {
        mParts = new ArrayList<>();
        URI uri = new URI(path);
        mPath = path;
        log.info("parsed uri: " + uri);
        switch (uri.getScheme()) {
            case "file":
                break;
            case "rtsp":
                break;
            case "rtp":
                break;
            default:
                log.warn("Unknown scheme: " + uri.getScheme());
                break;
        }
    }

    public MediaStream addPart(MediaStreamPart part) {
        if (part != null) {
            mParts.add(part);
        }
        return this;
    }

    public List<MediaStreamPart> getParts() {
        return mParts;
    }

    public String getDescription() {
        StringBuilder result = new StringBuilder();
        for (MediaStreamPart part : mParts) {
            result.append(part.getDescription());
        }
        return result.toString();
    }

    public String getPath() {
        return mPath;
    }

    public void setRtspPort(int rtspPort) {
        this.rtspPort = rtspPort;
    }

    public int getRtspPort() {
        return rtspPort;
    }
}