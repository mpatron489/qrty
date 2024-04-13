import './App.css';
import Header from './components/header';
import Footer from './components/footer';
import QRRequestForm from './components/qrRequestForm';
function App() {
  return (
    <div className="App">
      <Header></Header>
        <div id="contentWrapper">
              <QRRequestForm></QRRequestForm>
        </div>
        <Footer></Footer>
  </div>
  );
}

export default App;
