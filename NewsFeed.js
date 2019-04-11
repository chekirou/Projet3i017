import React, { Component } from 'react';
import Message from './Message'
class NewsFeed extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.tweets.map(({pseudo, message}) =>
					Message({pseudo, image, message})
					
				)


			)
	}
}

export default NewsFeed;