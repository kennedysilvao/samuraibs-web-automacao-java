package factories.usuarioFactory;

import model.User;

public class UsuarioDataFactory {
    public static User userData() {
        User user = new User();
        user.setName("Kennedy Silva de Oliveira");
        user.setEmail("kennedy@automacao.com");
        user.setPassword("pwd123");
        user.setIs_provider(true);

        return user;
    }

}
