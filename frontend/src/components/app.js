/*eslint-disable strict */
window.$ = window.jQuery = require('jquery');


var Header = require('./common/header');
var React = require('react');

var App = React.createClass({

	render: function() {
		return (
			<div>
				<Header />
				<div className="detail">
          			{this.props.children}
        		</div>
			</div>
		);
	}
});

module.exports = App;