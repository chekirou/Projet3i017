import React, { Component } from 'react';
import './Inscription.css';
class Inscription extends Component {
  constructor(props)
  {
  	super(props);
  }
render()
{
		return (
			<div className="conteneur">
				<div className="conteneurInscription">
					<div className="wraperInscription">
						<form className="formulaire" onSubmit={this.props.connect}>
							<div className="titre">
								<img src="https://www.brandcrowd.com/gallery/brands/pictures/picture12632215544704.jpg" />
							</div>
							<div className="divLastname">
								<label className="lastnameLabel"> Lastname </label>
								<input className="inputLastname" type="text" name="Lastname"/>
							</div>

							<div className="divName">
								<label className="Name"> Name </label>
								<input className="inputName" type="text" name="Name"/>
							</div>
							
							<div className="divLogin">
								<label className="loginLabel"> Login </label>
								<input className="inputLogin" type="text" name="Login"/>
							</div>
							
							<div className="divPass">
								<label className="pass"> Mot de passe </label>
								<input className="inputPass" type="password" name="pass"/>
							</div>
							
							<div className="divSexe">
								<label className="Sexe"> Sexe </label>
								<input className="inputSexe" type="text" name="Sexe"/>
							</div>
							
							<div className="divDate_naissance">
								<label className="Date_naissance"> Date_naissance </label>
								<input className="inputDate_naissance" type="text" name="Date_naissance"/>
							</div>
							
							<div className="divEmail">
								<label className="Email"> Email </label>
								<input className="inputEmail" type="text" name="Email"/>
							</div>
							
							
							<div className="bouton-conteneur">
								<div className="wraperBouton">
									<input className="bouton" type="submit" value='connexion'/>
								</div>
							</div>
			
						</form>	
					</div>
				</div>
			</div>
			)
  }
}

export default Login;
