import React from 'react'
import { BrowserRouter} from 'react-router-dom';

import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { ProductContextProvider } from './Context/ProductGlobalContext.tsx';

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
        <BrowserRouter>
        <ProductContextProvider>
        <App />
        </ProductContextProvider>
        </BrowserRouter>
  </React.StrictMode>,
)
