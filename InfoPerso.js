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
                    <div className="Info_titre">Information personnelles </div>
                    <div className="mail">Adresse email :  {this.props.email} </div>
                    <div className="naissance">Date de naissance : {this.props.date_naissance}</div>
                    <div className="sexe">Sexe : {this.props.sexe == 'F' ? "Femme": "Homme"}</div>
		        </div>
	        

	      	

	         
	</div>);
}

}
export default InfoPerso;
