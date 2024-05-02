import { Link } from 'react-router-dom'
import Expense from './Expense'
import { useEffect, useState } from 'react'
import axios from "axios";

const baseURL = "http://localhost:8080/expenses/";

const DetailsMain = () => {

  const[data, setData] = useState([]);


  useEffect(() => {
    axios.get(baseURL).then((response) => {
        setData(response.data.expenses)
      });
  

  }, [])
  
  return (
    <div className='details-main'>
        <div className='new-button'>
            <span>
            <Link to="/save" className="link-style">New</Link>
            </span>
        </div>
        {
          data.map((item, index) => <Expense key={index} 
          amount={item.amount} 
          date={new Date(item.date).toString().substring(4, 15)} 
          description={item.description}
          currency={item.currency}/>)
        }
    </div>
  )
}

export default DetailsMain
