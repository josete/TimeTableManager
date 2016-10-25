var Horario = function(){
	
	this.grupo = null;
	this.sesiones = null;
	
	this.generar = function(){
		if(this.grupo == null || this.sesiones == null){
			throw new Error("El horario no tiene grupo o sesiones");
		}else{
			console.log("Hola soy un horario que de momento no hace nada");
		}
	}
	
	this.setGrupo = function(grupo){
		this.grupo = grupo;
	}

	this.setSesiones = function(sesiones){
		this.sesiones = sesiones;
	}

	this.getSesiones = function(){
		return this.sesiones;
	}
}

module.exports = Horario;