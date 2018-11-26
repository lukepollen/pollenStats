# -*- coding: utf-8 -*-
"""
Created on Mon Jul 10 16:29:05 2017

@author: dulce-senorita
"""

from sqlalchemy import create_engine
import pandas as pd

engine = 'postgresql://postgres:N5ABLNsnV8mp@localhost:5432/analytics'
query = 'select * from pauzeradio_source;'
data = pd.read_sql_query(query, engine)
print(data)

from py4j.java_gateway import JavaGateway
theGate = JavaGateway()
theGate.jvm.pollenStats.LeastSquares.regressionLine("xOne", "yOne")
