import { Link } from 'react-router-dom'
import Expense from './Expense'
import { useEffect, useState } from 'react'
import axios from "axios";

const baseURL = "http://localhost:8080/expenses/";

const DetailsMain = () => {

  const[data, setData] = useState([]);



  useEffect(() => {
    axios.get(baseURL).then((response) => {
        //console.log(response)
        //console.log(response.data)
        //console.log(response.data.expenses)
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
        <div className='expenses-container'>
        {
          data.map((item, index) => <Expense key={index} amount={item.amount} date={item.date} description={item.description}/>)
        }
        </div>

         {/* <Expense amount={11000} date={"2020-1-3"} description={"Rent"}/> */}
    </div>
  )
}

export default DetailsMain
