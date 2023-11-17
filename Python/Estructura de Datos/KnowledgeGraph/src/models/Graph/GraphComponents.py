from dataclasses import dataclass
from typing import Optional
from src.models.Graph.Types import *

@dataclass
class Node:
    value: Optional[str] = None

    def __hash__(self):
        return hash(self.value)

@dataclass
class Edge:
    from_node: Node = None
    to_node: Node = None
    type: Optional[NodeTypes] = None