import React, { Component } from 'react';

class Logout extends Component {
  constructor(props)
  {
  	super(props);
  	this.state = props
  }
  render() {
    	return (
    	<button onclick={(event)=>this.state.attribut}/>);
  }
}

export default Logout;
