package top.zynorl.petplanet.auth.context;

import lombok.Data;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/26
 **/
@Data
public class RuntimeContextHolder {
    private static  final ThreadLocal<RuntimeContext> CURRENT_RUNTIME_CONTEXT = new ThreadLocal<>();

    public RuntimeContextHolder() {
    }

    public static RuntimeContext currentRuntimeContext(){
        return CURRENT_RUNTIME_CONTEXT.get();
    }

    public static void setCurrentRuntimeContext(RuntimeContext runtimeContext){
        CURRENT_RUNTIME_CONTEXT.set(runtimeContext);
    }

    public static void clear(){
        CURRENT_RUNTIME_CONTEXT.remove();
    }
}
