var Horario = function(){
	
	this.grupo = null;
	this.asignaturas = null;
	
	this.generar = function(){
		if(grupo == null || asignaturas == null){
			throw new Error("El horario no tiene grupo o asignaturas");
		}
	}
	
	this.setGrupo = function(grupo){
		this.grupo = grupo;
	}
}

module.exports = Horario;