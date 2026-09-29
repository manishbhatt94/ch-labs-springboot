package dev.moneysh.portfolio.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

public class ReferrerParser {

	public static String getReferrerPath(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader("Referer")).filter(referer -> !referer.trim().isEmpty())
				.map(ReferrerParser::parseUriPath).orElse("/");
	}

	private static String parseUriPath(String refererUrl) {
		try {
			String path = new URI(refererUrl).getPath();
			return (path == null || path.isEmpty()) ? "/" : path;
		} catch (URISyntaxException e) {
			return "/"; // Fallback if the header contains a malformed URL
		}
	}

}
