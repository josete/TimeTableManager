var Configuracion = function(){
    
    this.vacia = true;
    this.sesiones = [];
    this.horarios = [];

    this.isVacia = function(){
        return this.vacia;
    }

    this.anadirSesion = function(sesion){
        this.sesiones.push(sesion);
    }

    this.getSesiones = function(){
        return this.sesiones;
    }

    this.anadirHorario = function(horario){
        this.horarios.push(horario);
    }

    this.getHorarios = function(){
        return this.horarios;
    }

}

module.exports = Configuracion;