import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Details from './pages/Details'
import SavePage from './pages/SavePage'
import "./App.css"
import PageNotFound from './pages/PageNotFound'



function App() {


  return (
    <Router>
      <Routes>
        <Route path='/' Component={Home} />
        <Route path='/details' Component={Details} />
        <Route path='/save' Component={SavePage} />
        <Route path='*' Component={PageNotFound} />

      </Routes>


    </Router>
  )
}

export default App
