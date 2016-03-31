"use strict";

var React = require('react');

var Header = React.createClass({
	render: function() {
		return(
			<nav className="navbar navbar-default">
				<div className="container-fluid">
					<a href="/" className="navbar-brand">
						<img src="images/logoBetonleague.png" />
					</a>
				</div>
			</nav>
		)
	}
});


module.exports = Header;