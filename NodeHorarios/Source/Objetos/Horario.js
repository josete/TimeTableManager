var Horario = function () {

	this.grupo = null;
	this.sesiones = null;
	this.horaInicio = 8;
	this.horasDia = 6;
	this.horarioGenerado = {};
	this.asignaturasAnadidas = [];

	this.generar = function () {
		if (this.grupo == null || this.sesiones == null) {
			throw new Error("El horario no tiene grupo o sesiones");
		} else {
			horasTotalesDia = this.horasDia;
			actual = 0;
			while(horasTotalesDia >0){
				if(this.sesiones[actual].getAsignatura().diaActualPeude()){
					this.horarioGenerado[diaActual + "-" + horaActual] = this.sesiones[i];
					horasTotalesDia -= this.sesiones[i].getHoras();
					this.sesiones[actual].getAsignatura().setPuede(false);
				}
				actual++;
				
			}
					

		}
	}

	this.setGrupo = function (grupo) {
		this.grupo = grupo;
	}

	this.setSesiones = function (sesiones) {
		this.sesiones = sesiones;
	}

	this.getSesiones = function () {
		return this.sesiones;
	}

	this.imprimir = function () {
		console.log(this.horarioGenerado);
	}

	this.comprobarEsta = function (asignatura) {
		esta = false;
		for (i = 0; i < this.asignaturasAnadidas.length; i++) {
			if (this.asignaturasAnadidas[i] == asignatura) { esta = true; break; }
		}
		return esta;
	}
}

module.exports = Horario;