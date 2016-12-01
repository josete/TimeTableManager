var express = require('express');
var app = express();
var path = require("path");
var main = require("./Main.js");

app.use(express.static(__dirname + '/Views'));
horarios = new main();

app.get('/',function(req,res){
   res.sendFile(path.join(__dirname+'/Views/index.html'));
});

app.get('/getHorarioCurso',function(req,res){
    res.setHeader('Content-Type', 'application/json');
    res.send(horarios.generarHorarioParaMostrar(0));
});

app.listen(3000);