
import { Routes, Route } from 'react-router-dom';
import Home from './Pages/Home';
import './App.css'
import Navbar from './components/Navbar';
import Product from './Products/Product';

function App() {

  return (
  <>
    <Navbar />
    <Routes>
    <Route path="/" element={<Home />} />
   <Route path="/products/:id" element={<Product />} />
    </Routes>
    </>
    
  )
}

export default App
