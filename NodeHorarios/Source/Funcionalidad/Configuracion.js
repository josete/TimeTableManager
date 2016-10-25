var Configuracion = function(){
    
    this.vacia = true;
    this.sesiones = [];

    this.isVacia = function(){
        return this.vacia;
    }

    this.anadirSesion = function(sesion){
        this.sesiones.push(sesion);
    }

    this.getSesiones = function(){
        return this.sesiones;
    }

}

module.exports = Configuracion;