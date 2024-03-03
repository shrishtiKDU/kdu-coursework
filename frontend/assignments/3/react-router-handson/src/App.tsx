
import './App.css'
import Navbar from './components/Navbar'
import { Route, Routes } from 'react-router-dom'
import Explore from './Pages/Explore'
import WatchList from './Pages/WatchList'
import StockPage from './Pages/StockPage'
import Portfolio from './Pages/Portfolio'
import PageNotFound from './Pages/PageNotFound'

function App() {

  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Explore />} />
        <Route path="/watchlist" element={<WatchList/>} />
        <Route path="/stockpage/:name" element={<StockPage />} />
        <Route path="/portfolio" element={<Portfolio />} />
        <Route path="*" element={<PageNotFound />} />

      </Routes>
         
    </>
  )
}

export default App
