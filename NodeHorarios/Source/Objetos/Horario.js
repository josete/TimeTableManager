var Horario = function(){
	
	this.grupo = null;
	this.sesiones = null;
	this.horaInicio = 8;
	this.horasDia = 6;
	this.horarioGenerado = {};
	
	this.generar = function(){
		if(this.grupo == null || this.sesiones == null){
			throw new Error("El horario no tiene grupo o sesiones");
		}else{
			horaActual = 0;
			diaActual = 0;
			horasDiaRestantes = this.horasDia;
			for(i=0;i<this.sesiones.length;i++){
				if(Object.keys(this.horarioGenerado).length>0){
					if(!this.comprobarEsta(this.sesiones[i])){
						this.horarioGenerado[diaActual+"-"+horaActual] = this.sesiones[i];
					}
				}else{
					this.horarioGenerado[diaActual+"-"+horaActual] = this.sesiones[i];
				}
				horasDiaRestantes -= this.sesiones[i].getHoras();
				horaActual++;
				if(horasDiaRestantes==0){
					horaActual = 0;
					diaActual++;
					horasDiaRestantes = this.horasDia;
				}
			}
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
	
	this.imprimir = function(){
				console.log(this.horarioGenerado);
	}
	
	this.comprobarEsta = function(asignatura){
		esta = false;
		horaActual = 0;
			diaActual = 0;
		for(i=0;i<this.sesiones.length;i++){
			if(this.horarioGenerado[diaActual+"-"+horaActual].getAsignatura()==asignatura){esta=true;break;}
			horaActual++;
			if(horasDiaRestantes==0){
				horaActual = 0;
				diaActual++;
			}
		}
		return esta;
	}
}

module.exports = Horario;