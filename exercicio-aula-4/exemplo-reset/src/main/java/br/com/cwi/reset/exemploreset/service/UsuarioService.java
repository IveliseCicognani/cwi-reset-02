package br.com.cwi.reset.exemploreset.service;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        public List<Usuario> listarUsuarios() {
            return usuarioRepository.listarUsuarios();
        }

        public Usuario criarUsuario(Usuario usuario){
            if(usuario == null){
                throw new BadRequestException();
            }
            return usuarioRepository.salvarUsuario(usuario);
        }
        public void deletarUsuario(final String idDeletar){
            usuarioRepository.deletarUsuario(idDeletar);
        }

}
