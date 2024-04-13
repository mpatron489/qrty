async function getQR(){
    let qr;
    const res = await fetch('http://localhost:8080/getQRCode/SVG');
    document.createElement('svg').innerHTML(res);
}