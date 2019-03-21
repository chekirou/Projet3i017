import React, { Component } from 'react';
class Login extends Component {
  constructor(props)
  {
  	super(props);
  	this.state = props
  }
  render() {
    	return (

				<div id="connexion_main">
				    <h1> Ouvrir une session</h1>
				        <FORM method="get"  action={this.state.attribut}>
				        <div class="ids">
				            <span>login</span>
				            <INPUT type="text"  name="login"/>
				        </div>

				        <div class="ids">
				            <span>mot de passe</span>
				            <INPUT type="password " name="password"/>
				        </div>
				        <div class ="buttons"> 
				            <INPUT type="submit"  value="connexion"/>
				        </div>
				        <div class="links"> 
				            <div id="link1">
				                <a href="https://www.google.com/"> mot de passe perdu </a>
				            </div>
				            <div id="link2">
				                <a href="https://www.google.com/"> pas encore inscrit ? </a>
				                </div>
				        </div>
				    </FORM>
				</div>
    	
    	
    	
    	);
  }
}

export default Login;
