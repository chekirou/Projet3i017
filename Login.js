import React, { Component } from 'react';
import Logout from './Logout';
class Login extends Component {
  constructor(props)
  {
  	super(props);
  	this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit() {
    this.props.attribut()
    return( <h1>zrlkjrmv</h1>);
  }
  render() {
    	return (

				<div>
				    <h1> Ouvrir une session</h1>
				        <form onSubmit={this.props.attribut()}>
				        <div className="ids">
				            <span>login</span>
				            <input type="text"  name="login"/>
				        </div>

				        <div className="ids">
				            <span>mot de passe</span>
				            <input type="password " name="password"/>
				        </div>
				        <div className ="buttons"> 
				            <input type="submit"  value="connexion"/>
				        </div>
				        <div className="links"> 
				            <div id="link1">
				                <a href="https://www.google.com/"> mot de passe perdu </a>
				            </div>
				            <div id="link2">
				                <a href="https://www.google.com/"> pas encore inscrit ? </a>
				                </div>
				        </div>
				    </form>
				</div>
    		
    	
    	
    	);
  }
}

export default Login;
