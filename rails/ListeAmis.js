import React, { Component } from 'react';
import './InfoPerso.css';
import Ami from './ami'
class ListeAmis extends Component {
  constructor(props)
  {
  	super(props);
  }
render()
{

	return (
        this.props.liste.map(({pseudo}) =>
					
					<Ami pseudo={pseudo} goUser={this.props.goUser}  />
					
				)
    )

}

}
export default ListeAmis;
