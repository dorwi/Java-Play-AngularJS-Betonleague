var gzippo = require('gzippo');
var express = require('express');
var morgan = require('morgan');
var app = express();

app.use(morgan('dev'));
app.use(gzippo.staticGzip("" + __dirname + "/dist"));
app.listen(process.env.PORT || 5000);
app.use('./bower_components', express.static(__dirname + '/bower_components'));
app.use(express.static(__dirname + '/sample_responses'));
