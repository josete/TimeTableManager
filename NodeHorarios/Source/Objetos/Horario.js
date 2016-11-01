var Horario = function () {

	this.grupo = null;
	this.sesiones = null;
	this.horaInicio = 8;
	this.horasDia = 6;
	this.horarioGenerado = {};


	this.generar = function () {
		if (this.grupo == null || this.sesiones == null) {
			throw new Error("El horario no tiene grupo o sesiones");
		} else {
			horasTotalesDia = this.horasDia;
			actual = 0;
			dia = 0;
			horaActual = this.horaInicio;
			while(this.sesiones.length>0){
				if(this.sesiones[actual].getAsignatura().diaActualPuede()){
					this.horarioGenerado[dia + "-" + horaActual] = this.sesiones[actual];
					horasTotalesDia -= this.sesiones[actual].getHoras();
					horaActual += this.sesiones[actual].getHoras();
					this.sesiones[actual].getAsignatura().setPuede(false);
					this.sesiones.splice(actual,1);
				}
				actual++;
				if(horasTotalesDia <= 0){
					horasTotalesDia = this.horasDia;
					dia++;
					horaActual = this.horaInicio;
					this.resetear();
				}
				if(actual >= this.sesiones.length){
					actual = 0;
				}
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
		for(i=8;i<14;i+=2){
			for(j=0;j<4;j++){
				process.stdout.write(this.horarioGenerado[j+"-"+i].getAsignatura().getNombre());
				process.stdout.write("	");
			}
				process.stdout.write("\n");
		}
		//console.log(this.horarioGenerado);
	}

	this.resetear = function () {
		for(i=0;i<this.sesiones.length;i++){
			this.sesiones[i].getAsignatura().setPuede(true);
		}
	}
}

module.exports = Horario;