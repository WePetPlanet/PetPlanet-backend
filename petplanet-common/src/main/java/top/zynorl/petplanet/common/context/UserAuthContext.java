package top.zynorl.petplanet.common.context;

import top.zynorl.petplanet.common.security.AuthUser;

public class UserAuthContext {
    private static ThreadLocal<AuthUser> authUserThreadLocal = new ThreadLocal<>();

    public static AuthUser getAuthUser() {
        return authUserThreadLocal.get();
    }
    public static void setAuthUserThreadLocal(AuthUser authUser) {
        UserAuthContext.authUserThreadLocal.set(authUser);
    }
}
