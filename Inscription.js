import React, { Component } from 'react';
import './Inscription.css';
class Inscription extends Component {
  constructor(props)
  {
	  super(props);
	  this.handleInputChange = this.handleInputChange.bind(this);
	  this.subscribe = this.subscribe.bind(this);
	  this.setGender = this.setGender.bind(this)
  }
  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
	});
	console.log(this.state)
  }
  subscribe()
  {
	  this.props.subscribe(this.state);
  }
  setGender(event)
  {
	const name = event.target.name;
	const value = event.target.value === 'Homme' ? "M" : "F";
	this.setState({[name]: value} );
  }
render()
{
		return (
			<div className="conteneur">
				<div className="conteneurInscription">
					<div className="wraperInscription">
						<div className="formulaire">
							<div className="titre">
								<img src="https://www.brandcrowd.com/gallery/brands/pictures/picture12632215544704.jpg" />
							</div>
							<div className="divLastname">
								<label className="lastnameLabel"> Nom </label>
								<input className="inputLastname" type="text" name="Lastname" onChange={this.handleInputChange}/>
							</div>

							<div className="divName">
								<label className="Name"> Prenom </label>
								<input className="inputName" type="text" name="Name" onChange={this.handleInputChange}/>
							</div>
							
							<div className="divLogin">
								<label className="loginLabel"> Pseudo </label>
								<input className="inputLogin" type="text" name="Login" onChange={this.handleInputChange}/>
							</div>
							
							<div className="divPass">
								<label className="pass"> Mot de passe </label>
								<input className="inputPass" type="password" name="pass" onChange={this.handleInputChange}/>
							</div>
							
							<div className="divSexe">
								<label className="Sexe"> Sexe </label>
								<div onChange={this.setGender}>
        							<input  type="radio" value="Homme" name="Sexe"/> Homme
        							<input className="radio" type="radio" value="Femme" name="Sexe"/> Femme
      							</div>
							</div>
							
							<div className="divDate_naissance">
								<label className="Date_naissance"> Date_naissance </label>
								
							
							<input type="date" name="Date_naissance" onChange={this.handleInputChange}/>
							
							
							</div>
							
							<div className="divEmail">
								<label className="Email"> Email </label>
								<input className="inputEmail" type="text" name="Email" onChange={this.handleInputChange}/>
							</div>
							
							
							<div className="bouton-conteneur">
								<div className="wraperBouton">
									<input className="bouton" type="submit" value='connexion' onClick={this.subscribe}/>
								</div>
							</div>
			
						</div>	
					</div>
				</div>
			</div>
			)
  }
}

export default Inscription;
