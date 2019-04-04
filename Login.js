import React, { Component } from 'react';
import './Login.css';
class Login extends Component {
  constructor(props)
  {
  	super(props);
	this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  
  handleChange(event) {
    this.setState({login: event.target.value});
  }

  handleSubmit(event) {
    this.connect()
  }
  
render()
{
		return (
			<div className="conteneur">
				<div className="conteneurLogin">
					<div className="wraperLogin">
						<form className="formulaire" onSubmit={this.handleSubmit}>
							<div className="titre">
								<img src="https://www.brandcrowd.com/gallery/brands/pictures/picture12632215544704.jpg"/>
							</div>
							<div className="divLogin">
								<label className="loginLabel"> Login </label>
								<input className="inputLogin" type="text" ref={(input) => this.textInput = input}/>
							</div>

							<div className="divPass">
								<label className="pass"> Mot de passe </label>
								<input className="inputPass" type="password" ref="password"/>
							</div>
							<div className="bouton-conteneur">
								<div className="wraperBouton">
									<input className="bouton" type="submit" value='connexion'/>
								</div>
								
							</div>
							<div class="text-center p-t-115">
								<span class="texte1">
									Pas encore inscrit? 
								</span>

								<a class="texte2" href="#">
									   inscription
								</a>
							</div>
							<div>
								<a className="texte2" href="https://mail.google.com"> mot de passe oublié </a>
							</div>
						</form>	
					</div>
				</div>
			</div>
			)
  }
}

export default Login;
