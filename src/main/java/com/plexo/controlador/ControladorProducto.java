package com.plexo.controlador;

import com.plexo.productos.Producto;
import com.plexo.repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private RepositorioProducto repositorioProducto;

    @GetMapping(path = {"","/"})
    Page<Producto> productoList(@RequestParam(required = false) Boolean activo,
                                @PageableDefault(size = 6) Pageable pageable){
        if (activo == null){
            return repositorioProducto.findAll(pageable);
        }else{
            return repositorioProducto.findByActivo(activo, pageable);
        }
    }

    @GetMapping(path = {"/{productoID}"})
    Producto producto(@PathVariable("productoID") Integer productoID){
        return repositorioProducto.findById(productoID).get();
    }

/*  NO SE USA YA QUE SOLO SE CARGAN LOS PRODUCTOS DESDE EL USUARIO ADMINISTRADOR
    @PostMapping(path = {"","/"})
    ResponseEntity<?> agregarProducto(@Valid @RequestBody ProductoPost productoPost, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>("Error, campos invalidos", HttpStatus.BAD_REQUEST);
        }

        Producto producto = new Producto(productoPost.getNombre(), productoPost.getDescripcion(), productoPost.getImagen(), productoPost.getFichaTecnica());

        return ResponseEntity.ok(repositorioProducto.save(producto));
    }

    @PatchMapping(path = {"/{productoID}"})
    ResponseEntity<?> modificarProducto(@PathVariable("productoID") Integer productoID,
                                        @Valid @RequestBody ProductoPatch productoPatch, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>("Error, campos invalidos", HttpStatus.BAD_REQUEST);
        }

        if (repositorioProducto.existsById(productoID)){
            Producto producto = repositorioProducto.findById(productoID).get();

            if (productoPatch.getActivo() != null){
                producto.setActivo(productoPatch.getActivo());
            }
            if (productoPatch.getNombre() != null){
                producto.setNombre(productoPatch.getNombre());
            }
            if (productoPatch.getDescripcion() != null){
                producto.setDescripcion(productoPatch.getDescripcion());
            }
            if (productoPatch.getImagen() != null){
                producto.setImagen(productoPatch.getImagen());
            }
            if (productoPatch.getFichaTecnica() != null){
                producto.setFichaTecnica(productoPatch.getFichaTecnica());
            }

            producto.guardarFechaModificacion();
            return ResponseEntity.ok(repositorioProducto.save(producto));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = {"/{productoID}"})
    public void darDeBajaProducto(@PathVariable("productoID") Integer productoID){
        if (repositorioProducto.existsById(productoID)){
            Producto producto = repositorioProducto.findById(productoID).get();
            producto.setActivo(false);
            producto.guardarFechaModificacion();
            repositorioProducto.save(producto);
        }
    }
*/
}


