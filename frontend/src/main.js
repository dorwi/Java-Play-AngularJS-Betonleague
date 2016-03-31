"use strict";


var React = require('react');
var routes = require('./routes');

var Router = require('react-router').Router;
var hashHistory = require('react-router').hashHistory;
var reactDOM = require('react-dom');

reactDOM.render((<Router history={hashHistory}>{routes}</Router>), document.getElementById('app'));