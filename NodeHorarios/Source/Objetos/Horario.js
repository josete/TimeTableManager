var prologjs = require( '../../prologjs-master/main' );

var Horario = function () {

	this.grupo = null;
	this.sesiones = null;
	this.horaInicio = 8;
	this.horasDia = 6;
	this.horarioGenerado = {};
	this.generado = false;


	this.generar = function () {
		if (this.grupo == null || this.sesiones == null) {
			throw new Error("El horario no tiene grupo o sesiones");
		} else {
			horasTotalesDia = this.horasDia;
			actual = 0;
			dia = 0;
			horaActual = this.horaInicio;
			intento = 0;//Pruebas
			while(this.sesiones.length>0){
				intento++;
				if(this.sesiones[actual].getAsignatura().diaActualPuede()&&!this.sesiones[actual].getAsignatura().getProfesor().getClaseAUnaHora(dia + "-" + horaActual)){
					this.horarioGenerado[dia + "-" + horaActual] = this.sesiones[actual];					
					this.sesiones[actual].getAsignatura().getProfesor().anadirClase(dia + "-" + horaActual,this.sesiones[actual]);
					horasTotalesDia -= this.sesiones[actual].getHoras();
					horaActual += this.sesiones[actual].getHoras();
					this.sesiones[actual].getAsignatura().setPuede(false);
					this.sesiones.splice(actual,1);
					intento=0;
				}
				actual++;
				if(horasTotalesDia <= 0 || intento>3){
					horasTotalesDia = this.horasDia;
					dia++;
					horaActual = this.horaInicio;
					this.resetear();
				}
				if(actual >= this.sesiones.length){
					actual = 0;
				}
			}
			this.horarioGenerado["Dias"] = dia;
			this.generado = true;
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
		process.stdout.write("Horario Grupo:"+this.grupo.getNombre()+" "+this.grupo.getCurso().getCurso()+"\n");
		for(i=this.horaInicio;i<(this.horaInicio+this.horasDia);i+=2){
			for(j=0;j<(this.horarioGenerado["Dias"]+1);j++){
				try{
				process.stdout.write(this.horarioGenerado[j+"-"+i].getAsignatura().getNombre());
				process.stdout.write("	");
				}catch(err){}
			}
				process.stdout.write("\n");
		}
		process.stdout.write("---------------------------\n");
	}

	this.resetear = function () {
		for(i=0;i<this.sesiones.length;i++){
			this.sesiones[i].getAsignatura().setPuede(true);
		}
	}

	this.getGenerado = function(){
		return this.generado;
	}
}

module.exports = Horario;