import React from 'react';
import ImageFetcher from '../functionComponents/imageFetcher';
import { renderIntoDocument } from 'react-dom/test-utils';
class QRRequestForm extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            selectedImageType: 'SVG',
            url: '',
            imageOutPut: null};
    };

    
    handleSubmit = (e) => {
        e.preventDefault(); 
        console.log("you made it into the function");
            this.setState({
                imageOutPut: ImageFetcher(this.state.selectedImageType, this.state.url)
            });
        console.log(this.state.imageOutPut);
        // var qrResponseElement = React.createElement(
        //     "img",
        //     {src: this.state.imageOutPut},
        //     null
        // );
        
          
        console.log("You fetched the thing");
    }

    render(){
        const formWrapperStyle = {
            display: "flex",
            flexDirection: "column",
            maxWidth: "15%",
            margin: "10px"
        }
        const labelItemStyle = {
            margin: "12px"
        }

        var imageTypeChoices = [
            {value: 'SVG',  label: 'SVG'},
            {value: 'PNG',  label: 'PNG'},
            {value: 'JPEG', label: 'JPEG'}
        ];
        return <div id="formWrapper" style={formWrapperStyle}>
            {/* {this.state.imageOutPut && <img src={this.state.imageOutPut} alt='QRCode'/>} */}
            {this.state.imageOutPut ? <img src={this.state.imageOutPut} alt='QRCode'/> : null}
            <form style={labelItemStyle} onSubmit={this.handleSubmit} id='qrRequestForm'>            
                <label>
                URL:  
                    <input 
                    type="text" 
                    name="name" 
                    style={labelItemStyle} 
                    onChange={(e) => this.setState({url: e.target.value})}/>
                </label>
                <label style={labelItemStyle}>
                    Image Type:
                </label>
                <select 
                    name="imageTypes" 
                    id="imageTypeSelector" 
                    value={this.state.selectedImageType}
                    onChange={(e) => this.setState({selectedImageType: e.target.value})}
                >
                    {/* <option value='SVG'>SVG</option> */}
                    <option value='PNG'>PNG</option>
                    <option value='JPEG'>JPEG</option>
               </select>
                <input type="submit" value="Submit"/>
           </form>
        </div>
    }
}

export default QRRequestForm;