import React, { Component } from 'react';
import './InfoPerso.css';
class InfoPerso extends Component {
  constructor(props)
  {
  	super(props);
  }
render()
{

	return (
	<div className="InfoPerso">
	    

	        
	        	<div className="infos_utilisateur_perso">
                    <div className="Info_titre">Infos Perso </div>
                    <div className="mail">Adresse email : </div>
		        	<div className="email">{this.props.email}</div>
                    <div className="naissance">Date de naissance : </div>
                    <div className="dat_N">{this.props.date_naissance}</div>
                    <div className="Sexe">Sexe : {this.props.sexe}</div>
                    <div className="sexe">{this.props.sexe}</div>
		        </div>
	        

	      	

	         
	</div>);
}

}
export default InfoPerso;
