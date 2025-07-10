public static String getEmailOfLoggedInUser(Authentication authentication) {
    if (authentication instanceof OAuth2AuthenticationToken) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User oauth2User = oauthToken.getPrincipal();
        String clientId = oauthToken.getAuthorizedClientRegistrationId();

        if (clientId.equalsIgnoreCase("google")) {
            return oauth2User.getAttribute("email"); // Google always returns email
        } else if (clientId.equalsIgnoreCase("github")) {
            // GitHub may not return email if not public
            String email = oauth2User.getAttribute("email");
            return email != null ? email : oauth2User.getAttribute("login") + "@github.com";
        }
    }
    return authentication.getName(); // For DB users
}