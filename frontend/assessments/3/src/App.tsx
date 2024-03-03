
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Home from './Pages/Home'
import { Provider } from 'react-redux'
import { store } from './redux/store'

function App() {

  return (
 
    <Provider store={store}>
    <BrowserRouter>  
    <Routes>
    <Route path="/" element={<Home />} />
    </Routes>
    </BrowserRouter>
    </Provider>
  )
}

export default App
