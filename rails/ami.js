import React, { Component } from 'react';
import './InfoPerso.css';
class Ami extends Component {
  constructor(props)
  {
      super(props);
      this.goUser = this.goUser.bind(this);
  }
  goUser()
  {
	  this.props.goUser(this.props.pseudo);
  }
render()
{

	return (
	<div className="ami" onClick={this.goUser}>
	      {this.props.pseudo}
	         
	</div>);
}

}
export default Ami;